import time
import random

# Benchmarking for Subset Sum Problem (SSP)
def benchmark_subset_sum():
    trials = 10
    for size in range(10, 101, 10):  # Increase input size by 10
        total_time = 0
        for _ in range(trials):
            set = [random.randint(1, 100) for _ in range(size)]
            target_sum = random.randint(1, size * 100)
            start_time = time.time()
            # Call isSubsetSum function here
            end_time = time.time()
            total_time += end_time - start_time
        average_time = total_time / trials
        print(f"SSP - Input Size: {size}, Average Time: {average_time:.6f} seconds")

# Benchmarking for Traveling Salesman Problem (TSP)
def benchmark_tsp():
    trials = 10
    for size in range(4, 13):  # Increase number of cities
        total_time = 0
        for _ in range(trials):
            graph = [[random.randint(1, 100) for _ in range(size)] for _ in range(size)]
            start_time = time.time()
            # Call tsp function here
            end_time = time.time()
            total_time += end_time - start_time
        average_time = total_time / trials
        print(f"TSP - Number of Cities: {size}, Average Time: {average_time:.6f} seconds")

# Benchmarking for Boolean Satisfiability Problem (SAT)
def benchmark_sat():
    trials = 10
    for size in range(3, 10):  # Increase number of variables
        total_time = 0
        for _ in range(trials):
            clauses = [(random.randint(-1, 1), random.randint(-1, 1), random.randint(-1, 1)) for _ in range(size)]
            start_time = time.time()
            # Call isSatisfiable function here
            end_time = time.time()
            total_time += end_time - start_time
        average_time = total_time / trials
        print(f"SAT - Number of Variables: {size}, Average Time: {average_time:.6f} seconds")

# Call benchmarking functions
benchmark_subset_sum()
benchmark_tsp()
benchmark_sat()
