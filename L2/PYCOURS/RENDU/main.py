import pandas as pd
import matplotlib.pyplot as plt


class Utils:
    def __init__(self,url):
        self.file = pd.read_csv(url)  
    def get_describe(self):
        return self.file.describe()
    def clear(self):
        self.file = self.file.drop(columns=["Comments"])
        self.file = self.file.dropna()
        self.file["Date Egg"] = pd.to_datetime(self.file["Date Egg"])
    def get_info(self):
        return self.file.info()
    def get_file(self):
        return self.file
    def get_filtre(self,request):
        return self.file.query(request)
    def get_histo(self,col):
        try : 
            self.file.hist(column=col)
            plt.savefig("hist.png")
            plt.show()
            plt.clf()
        except:
            print("erreur peut etre pas des nb")
            return 1
        return 0
    def get_histo_by(self,col,b):
        try : 
            self.file.hist(column=col,by=b)
            plt.savefig("histby.png")
            plt.show()
            plt.clf()
        except:
            print("erreur peut etre pas des nb")
            return 1
        return 0

         
    



if __name__ == "__main__":
    util = Utils("https://raw.githubusercontent.com/allisonhorst/palmerpenguins/master/inst/extdata/penguins_raw.csv")
    util.clear()
    print(util.get_info())
    print(util.get_file())
    print(util.get_filtre("`Delta 13 C (o/oo)` == -25.29805"))
    util.get_histo('Culmen Length (mm)')
    util.get_histo_by('Body Mass (g)','Species')
    import tkinter
    top = tkinter.Tk()
    top.title("Main Window")
    top.geometry("500x400")
    top.mainloop()