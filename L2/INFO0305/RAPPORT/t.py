import socket
import subprocess
import re

HOST = 'localhost'
PORT = 4000
C_BINARY = './keygen'

def generate_serial_with_c(username: str) -> str:
    proc = subprocess.run(
        [C_BINARY],
        input=(username + "\n").encode('utf-8'),
        capture_output=True,
        check=True
    )
    # .strip('\r\n') enlève le saut de ligne du C pour éviter d'envoyer "\n\n" !
    return proc.stdout.decode('utf-8').strip('\r\n')

def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((HOST, PORT))
        print(f"[*] Connecté à {HOST}:{PORT}\n")
        
        buffer = ""
        while True:
            data = s.recv(4096)
            if not data:
                print("\n[*] Fin de la connexion.")
                break
            
            chunk = data.decode('utf-8', errors='replace')
            print(chunk, end='', flush=True)
            buffer += chunk
            
            while ">>>" in buffer:
                question_block, buffer = buffer.split(">>>", 1)
                match = re.search(r"username:\s*([^\r\n]+)", question_block)
                if match:
                    username = match.group(1).strip()
                    serial = generate_serial_with_c(username)
                    print(f" {serial}")
                    
                    # Ici on envoie UN SEUL \n
                    s.sendall((serial + "\n").encode('utf-8'))

if __name__ == "__main__":
    main()
    