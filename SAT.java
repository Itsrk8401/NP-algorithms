// Boolean Satisfiability Problem (SAT) implementation
import java.util.*;

public class SAT {
    static class Clause {
        int var1;
        int var2;
        int var3;
        
        public Clause(int var1, int var2, int var3) {
            this.var1 = var1;
            this.var2 = var2;
            this.var3 = var3;
        }
        
        boolean evaluate(boolean[] assignment) {
            return (var1 < 0 ? !assignment[-var1] : assignment[var1]) ||
                   (var2 < 0 ? !assignment[-var2] : assignment[var2]) ||
                   (var3 < 0 ? !assignment[-var3] : assignment[var3]);
        }
    }
    
    static boolean isSatisfiable(Clause[] clauses, int n) {
        boolean[] assignment = new boolean[n + 1];
        Arrays.fill(assignment, false);
        for (int i = 0; i < (1 << n); i++) {
            for (Clause clause : clauses) {
                if (!clause.evaluate(assignment))
                    break;
                if (clause == clauses[clauses.length - 1])
                    return true;
            }
            for (int j = 1; j <= n; j++) {
                if (assignment[j])
                    assignment[j] = false;
                else {
                    assignment[j] = true;
                    break;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Clause[] clauses = {new Clause(1, 2, -3), new Clause(-1, -2, -3), new Clause(1, -2, 3)};
        int n = 3;
        if (isSatisfiable(clauses, n))
            System.out.println("Satisfiable");
        else
            System.out.println("Unsatisfiable");
    }
}
