package HW3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author DimS on 19.11.2022
 */

//�������� ����������, ������� ����� ����������� � ������������ ��������� ������ � ������������ �������, �����������
// ��������:
//        ������� ��� �������� ������������ ������������� ���
//        ������� ������:
//        �������,���,��������-������
//        ����_��������-������ ������� dd.mm.yyyy
//        �����_��������-����� ����������� ����� ��� ��������������
//        ���-������ ��������� f ��� m.
//        ���������� ������ ��������� ��������� ������ �� ����������. ���� ���������� �� ��������� � ���������,
//        ������� ��� ������, ���������� ��� � �������� ������������ ���������, ��� �� ���� ������ � ������ ������,���
//        ���������.
//        ���������� ������ ���������� ���������� ���������� �������� � �������� �� ��� ��������� ���������.���� �������
//        ������ �� ���������, ����� ������� ����������, ��������������� ���� ��������. ����� ������������ ����������
//        ���� java � ������� ����. ���������� ������ ���� ��������� ����������, ������������ �������� ��������� �
//        �����������, ��� ������ �������.
//        ���� �� ������� � ���������� �����, ������ ��������� ���� � ���������, ������ �������, � ���� � ���� ������
//        ������
//        ���������� ���������� ������,����
//<�������><���><��������><������������><�������������><���>
//������������ ������ ���������� � ���� � ��� �� ����,� ��������� ������.
//        �� �������� ������� ���������� � ������.
//        ��� ������������� �������� � �������-������� � ����, ���������� ������ ���� ��������� ����������, ������������
//        ������ ������� ��������� ������.

public class Task1 {
    public static void main(String[] args) {
        Record record = new Record();
        record.InputData();
        record.DataToFile();
    }
}

class Record{
    private String data;
    private String[] strArray;
    private final int countData = 6;

    public void InputData(){
        Scanner scanner = new Scanner(System.in);

        int res;
        do {
            System.out.println("������� ������ � ��������� ������� ����� ������: ");
            System.out.println("""
                    ������� ��� �������� ������������ ������������� ���
                    ������� ������:
                    �������,���,��������-������
                    ����_��������-������ ������� dd.mm.yyyy
                    �����_��������-����� ����������� ����� ��� ��������������(11 ����)
                    ���-������ ��������� f ��� m:
                    """);
            this.data = scanner.nextLine();
            res = CheckQuantity();
            if(res == -1){
                System.out.println("�� ����� ������ ������, ��� �����, ���� ���������� �������");
            }
            if (res == -2) {
                System.out.println("�� ����� ������ ������, ��� �����");
            }

            try {
                ParseData();
            } catch (InputException e) {
                e.printStackTrace();
                res = -3;
            }
        }

        while(res < 0);
        scanner.close();
    }

    private void ParseData() throws InputException{
        if (!strArray[0].matches("[a-zA-Z�-���-ߨ]+")){
            throw new InputException("� ������� {" + strArray[0] + "} ������ ���� ������ �����");
        }
        if (!strArray[1].matches("[a-zA-Z�-���-ߨ]+")){
            throw new InputException("� ����� {" + strArray[1] + "} ������ ���� ������ �����");
        }
        if (!strArray[2].matches("[a-zA-Z�-���-ߨ]+")){
            throw new InputException("� �������� {" + strArray[2] + "} ������ ���� ������ �����");
        }
        if (!strArray[3].matches("\\d{2}\\.\\d{2}\\.\\d{4}")){
            throw new InputException("����������� ������� ���� �������� {" + strArray[3] + "}");
        }
        if (!strArray[4].matches("\\d{11}")){
            throw new InputException("����������� ����� ����� �������� {" + strArray[4] + "}");
        }
        if (!strArray[5].matches("[fm]")){
            throw new InputException("����������� ������ ��� {" + strArray[5] + "}");
        }
    }

    private int CheckQuantity() {
        strArray = data.split("\\s+");  // ������ ���� �������� 01.01.1999 22222222222 m - �������� ������
        if (strArray.length < this.countData){
            return -1;
        }
        if (strArray.length > this.countData){
            return -2;
        }
        return 0;
    }

    public void DataToFile(){
        try(FileWriter writer = new FileWriter(strArray[0]+".txt", true)) {
            data = String.join(" ", strArray) + "\n";
            writer.write(data);
            System.out.println("������ ������� �������� � ���� "+ strArray[0] + ".txt");
        }
        catch(IOException e){
            System.out.println("������ ������ � ����");
            e.getStackTrace();
        }
    }
}

class InputException extends Exception{//Runtime

    public InputException(String e) {super(e);}
}
