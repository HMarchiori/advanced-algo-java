package dynamic_programming;

public class EditionProblem {

    static int iterationCounter;    
    static int instructionCounter;  // 👑 O novo ícone da performance

    public static int editDistanceRecursive(String start, String fin, int i, int j) {
        iterationCounter++;
        instructionCounter++; // chamada do método

        if (i == 0 && j == 0) {
            instructionCounter++;
            return 0;
        }
        if (i == 0) {
            instructionCounter++;
            return j;
        }
        if (j == 0) {
            instructionCounter++;
            return i;
        }

        instructionCounter++; // comparação de char
        if (start.charAt(i - 1) == fin.charAt(j - 1)) {
            instructionCounter++;
            return editDistanceRecursive(start, fin, i - 1, j - 1);
        }

        int substitute = editDistanceRecursive(start, fin, i - 1, j - 1) + 1;
        int insert = editDistanceRecursive(start, fin, i, j - 1) + 1;
        int delete = editDistanceRecursive(start, fin, i - 1, j) + 1;

        instructionCounter += 4; // atribuições + Math.min
        return Math.min(substitute, Math.min(insert, delete));
    }

    public static int editDistanceDynamic(String start, String fin) {
        instructionCounter++;
        int m = start.length();
        int n = fin.length();
        int[][] pd = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            instructionCounter++;
            pd[i][0] = pd[i - 1][0] + 1;
        }
        for (int j = 1; j <= n; j++) {
            instructionCounter++;
            pd[0][j] = pd[0][j - 1] + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                instructionCounter++;
                int custoExtra = (start.charAt(i - 1) == fin.charAt(j - 1)) ? 0 : 1;
                pd[i][j] = Math.min(pd[i - 1][j] + 1,
                                    Math.min(pd[i][j - 1] + 1, pd[i - 1][j - 1] + custoExtra));
                instructionCounter += 3;
            }
        }
        return pd[m][n];
    }

    public static void main(String[] args) {

        String s1 = "Casablanca";
        String s2 = "Portentoso";
    
        // 💻 Recursiva
        iterationCounter = 0;
        instructionCounter = 0;
        long startTime = System.nanoTime();
        int result = editDistanceRecursive(s1, s2, s1.length(), s2.length());
        long endTime = System.nanoTime() - startTime;
        System.out.printf(
            "\neditDistanceRecursive(%d,%d)\nIterações: %d\nInstruções: %d\nTempo: %.4f ms\nResultado: %d\n",
            s1.length(), s2.length(), iterationCounter, instructionCounter, endTime / 1_000_000.0, result
        );
    
        // ⚡ Dinâmica (caso pequeno)
        iterationCounter = 0;
        instructionCounter = 0;
        long startTime2 = System.nanoTime();
        int result2 = editDistanceDynamic(s1, s2);
        long endTime2 = System.nanoTime() - startTime2;
        System.out.printf(
            "\neditDistanceDynamic(%d,%d)\nIterações: %d\nInstruções: %d\nTempo: %.4f ms\nResultado: %d\n",
            s1.length(), s2.length(), iterationCounter, instructionCounter, endTime2 / 1_000_000.0, result2
        );
    
        // ✨ Teste grandioso, tipo uma Vogue September Issue
        String s3 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
            "simplify the build processes in the Jakarta Turbine project. There were several" + 
            " projects, each with their own Ant build files, that were all slightly different." +
            "JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+ 
            "definition of what the project consisted of, an easy way to publish project information" +
            "and a way to share JARs across several projects. The result is a tool that can now be" +
            "used for building and managing any Java-based project. We hope that we have created " +
            "something that will make the day-to-day work of Java developers easier and generally help " +
            "with the comprehension of any Java-based project.";
    
        String s4 = "This post is not about deep learning. But it could be might as well. This is the power of " +
            "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
            "ask? I am going to try to answer this question in this article." + 
            "Go to the profile of Marin Vlastelica Pogančić" + 
            "Marin Vlastelica Pogančić Jun";
    
        iterationCounter = 0;
        instructionCounter = 0;
        long startTime3 = System.nanoTime();
        int result3 = editDistanceDynamic(s3, s4);
        long endTime3 = System.nanoTime() - startTime3;
        System.out.printf(
            "\neditDistanceDynamic (texto grande)\nTamanhos: (%d,%d)\nInstruções: %d\nTempo: %.4f ms\nResultado: %d\n",
            s3.length(), s4.length(), instructionCounter, endTime3 / 1_000_000.0, result3
        );

    }
}