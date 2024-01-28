import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class assignment5 {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        int num, in;
        String file1, file2;
        System.out.println("if you are entering data from a file please input 2 if not please input 1");
        num=scnr.nextInt();
        if (num==1) {
            System.out.println("enter one number for the columns and rows");
            in=scnr.nextInt();
            scnr.close();
        
            int[][] mat1 = new int[in][in];
            int[][] mat2 = new int[in][in];
            int[][] mat3 = new int[in][in];        
            Random rand = new Random();
            int i, j, k;
            for (i=0; i<mat1.length; i++){
                for (j=0; j<mat1[i].length; j++){
                    mat1[i][j]=rand.nextInt(10);
                }

            }
            for (i=0; i<mat2.length; i++){
                for (j=0; j<mat2[i].length; j++){
                    mat2[i][j]=rand.nextInt(10);
                }

            }
            for (i=0; i<mat3.length; i++){
                for (j=0; j<mat3[i].length; j++){
                    mat3[i][j]=0;
                    for (k=0; k<mat1[i].length; k++){
                        mat3[i][j]+=mat1[i][k]*mat2[k][j];
                    }
                }

            }
            
            System.out.println("matrix 1:");
            for (i=0; i<mat1.length; i++){
                System.out.println(Arrays.toString(mat1[i]));
            }
            System.out.println("matrix 2:");
            for (i=0; i<mat2.length; i++){
                System.out.println(Arrays.toString(mat2[i]));
            }
            System.out.println("matrix 3:");
            for (i=0; i<mat3.length; i++){
                System.out.println(Arrays.toString(mat3[i]));
            }
            System.out.println();
            FileWriter writer = new FileWriter("matrix3.txt");
            BufferedWriter buffer = new BufferedWriter(writer);            
            for (i=0; i<mat3.length; i++){
                buffer.write(Arrays.toString(mat3[i]));
                buffer.newLine();                              
            
            }
            buffer.close();
            
        }
        if (num==2){
        System.out.println("enter first file name");
        file1=scnr.next();
        System.out.println("enter second file name");
        file2=scnr.next();
        FileReader reader = new FileReader(file1);
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        String[]size=line.split(" ");
        int rows = Integer.parseInt(size[0]);
        int columns= Integer.parseInt(size[1]);
        int[][]mat1 =new int[rows][columns];
        int i, j ,k;
        for  (i =0; i<rows; i++){
            line = br.readLine();
            String[]row=line.split(" ");
            for (j=0;j < columns; j++){
             mat1[i][j] = Integer.parseInt(row[j]);
            }
        }
        br.close();
        FileReader rdr = new FileReader(file2);
        BufferedReader r = new BufferedReader(rdr);
        String lne = r.readLine();
        String[]sz=lne.split(" ");
        int rowz = Integer.parseInt(sz[0]);
        int cols= Integer.parseInt(sz[1]);
        int[][]mat2 =new int[rowz][cols];
        
        for  (i =0; i<rowz; i++){
            lne = r.readLine();
            String[]rw=lne.split(" ");
            for (j=0;j < cols; j++){
             mat2[i][j] = Integer.parseInt(rw[j]);
            }
        }
        r.close();
        int[][] mat3 = new int[columns][rowz];
        for (i=0; i<mat3.length; i++){
            for (j=0; j<mat3[i].length; j++){
                mat3[i][j]=0;
                for (k=0; k<mat1[i].length; k++){
                    mat3[i][j]+=mat1[i][k]*mat2[k][j];
                }
            }

        }
        
        System.out.println("matrix 1:");
        for (i=0; i<mat1.length; i++){
            System.out.println(Arrays.toString(mat1[i]));
        }
        System.out.println("matrix 2:");
        for (i=0; i<mat2.length; i++){
            System.out.println(Arrays.toString(mat2[i]));
        }
        System.out.println("matrix 3:");
        for (i=0; i<mat3.length; i++){
            System.out.println(Arrays.toString(mat3[i]));
        }
        System.out.println();
        FileWriter writer = new FileWriter("matrix3.txt");
        BufferedWriter buffer = new BufferedWriter(writer);            
        for (i=0; i<mat3.length; i++){
            buffer.write(Arrays.toString(mat3[i]));
            buffer.newLine();                              
        
        }
        buffer.close();
        }
        

    }
    
}