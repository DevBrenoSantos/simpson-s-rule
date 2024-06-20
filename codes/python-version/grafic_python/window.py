import ctypes
from ctypes import c_double, c_int
import tkinter as tk
from tkinter import messagebox

# Carregar a biblioteca C
lib = ctypes.CDLL('./simpson.dll')
lib.simpson.argtypes = [c_double, c_double, c_int]
lib.simpson.restype = c_double

def calculate():
    try:
        a = float(entry_a.get())
        b = float(entry_b.get())
        n = int(entry_n.get())
        result = lib.simpson(a, b, n)
        messagebox.showinfo("Resultado", f"O resultado do cálculo de Simpson é: {result}")
    except ValueError:
        messagebox.showerror("Erro", "Por favor, insira valores válidos.")

# Criação da interface gráfica
root = tk.Tk()
root.title("Regra de Simpson")

tk.Label(root, text="a:").grid(row=0, column=0, pady=10)
entry_a = tk.Entry(root)
entry_a.grid(row=0, column=1, pady=10)

tk.Label(root, text="b:").grid(row=1, column=0,pady=10)
entry_b = tk.Entry(root)
entry_b.grid(row=1, column=1, pady=10)

tk.Label(root, text="Número de subdivisões n:").grid(row=2, column=0 ,pady=10)
entry_n = tk.Entry(root)
entry_n.grid(row=2, column=1, pady=10)

tk.Button(root, text="Calcular", command=calculate).grid(row=3, column=0, columnspan=2, pady=10)

root.mainloop()
