import pandas as pd

data = {
    'Commercial': ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'],
    'X': [20, 25, 15, 30, 10, 28, 18, 22],
    'Y': [5, 8, 2, 10, 1, 6, 3, 4],
    'Z': [5, 7, 4, 9, 2, 8, 3, 6]
}
df = pd.DataFrame(data)

r_pearson = df['X'].corr(df['Y'], method='pearson')
r_spearman = df['X'].corr(df['Y'], method='spearman')
r_kendall = df['X'].corr(df['Y'], method='kendall')

print(f"1. Pearson (r)         : {r_pearson:.4f}")
print(f"2. Spearman (rho)      : {r_spearman:.4f}")
print(f"3. Kendall tau-a (tau) : {r_kendall:.4f}")                                                                    