package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.ForEachStmt;

public class AutoGrader {

    // Test if the code uses only for-each loop and not regular for, while, or do-while loops
    public boolean testForEachLoopOnly(String filePath) throws IOException {
        System.out.println("Starting testForEachLoopOnly with file: " + filePath);

        File participantFile = new File(filePath); // Path to participant's file
        if (!participantFile.exists()) {
            System.out.println("File does not exist at path: " + filePath);
            return false;
        }

        FileInputStream fileInputStream = new FileInputStream(participantFile);
        JavaParser javaParser = new JavaParser();
        CompilationUnit cu;
        try {
            cu = javaParser.parse(fileInputStream).getResult()
                    .orElseThrow(() -> new IOException("Failed to parse the Java file"));
        } catch (IOException e) {
            System.out.println("Error parsing the file: " + e.getMessage());
            throw e;
        }

        System.out.println("Parsed the Java file successfully.");

        boolean hasForEachLoop = false;

        // Log the parsed for-each loop statements
        System.out.println("------ for-each Loop Statements ------");
        for (ForEachStmt forEachStmt : cu.findAll(ForEachStmt.class)) {
            System.out.println("for-each loop found: " + forEachStmt);
            hasForEachLoop = true;
        }

        // Check if only for-each loop is used and no 'for', 'while', or 'do-while'
        System.out.println("Has for-each loop: " + hasForEachLoop);

        boolean result = hasForEachLoop;
        System.out.println("Test result: " + result);

        return result;
    }
}
