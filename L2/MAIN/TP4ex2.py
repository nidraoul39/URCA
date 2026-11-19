# Code Python pour l'Exercice 2
import numpy as np
import pandas as pd
from scipy.stats import chi2_contingency

cx = [3350, 5650, 7950]
cy = [65, 95, 125, 155]
nij = np.array([[5, 3, 0, 1], [2, 5, 3, 2], [0, 2, 4, 10]])
N = nij.sum()

fij = nij / N
fi_dot = fij.sum(axis=1)
f_dot_j = fij.sum(axis=0)

mean_x = np.sum(cx * fi_dot)
std_x = np.sqrt(np.sum(fi_dot * (cx - mean_x)**2))

mean_y = np.sum(cy * f_dot_j)
std_y = np.sqrt(np.sum(f_dot_j * (cy - mean_y)**2))

cov_xy = np.sum(fij * np.outer(cx, cy)) - mean_x * mean_y
r_pearson = cov_xy / (std_x * std_y)

chi2, p_val, dof, _ = chi2_contingency(nij)

print(f"Covariance : {cov_xy:.2f}")
print(f"Pearson r  : {r_pearson:.4f}")
print(f"Chi2: {chi2:.2f}, p-val: {p_val:.4f}")