import java.util.ArrayList;
import java.util.Scanner;

public class test
{
    public static void main(String[] args)
    {
        ArrayList<Student> array = new ArrayList<Student>();
        Scanner input = new Scanner(System.in);
        int select = 0;
        Student s = new Student();
        while(true)
        {
            System.out.println("-------ѧ������ϵͳ-------");
            System.out.println("1.���ѧ��");
            System.out.println("2.ɾ��ѧ��");
            System.out.println("3.�޸�ѧ��");
            System.out.println("4.��ѯ����ѧ��");
            System.out.println("5.�˳�");
            System.out.println("--------------------------");
            
            try
            {
                select = input.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("Error");
            };
            
            
            if(select <= 0 || select >= 6)
            {
                System.out.println("������ 1 �� 5 �����֣�\n");
            }
            else
            {
                switch(select)
                {
                    case 1 :
                    System.out.println("�����ѧ����");
                    addStudent(array);
                    break;
                    case 2 :
                    System.out.println("��ɾ��ѧ����");
                    deleteStudent(array);
                    break;
                    case 3 :
                    System.out.println("���޸�ѧ����");
                    modifyStudent(array);
                    break;
                    case 4 :
                    System.out.println("����ѯ����ѧ����");
                    checkStudent(array);
                    break;
                    case 5 : 
                    System.out.println("Thank you");
                    System.exit(0);
                    break;
                }
            }
        }
    }
    //��ӷ���
    public static void addStudent(ArrayList<Student> array)
    {
        Scanner input1 = new Scanner(System.in);
        boolean checkId = false;
        String id;

        //���id�Ƿ��ظ�
        while(true)
        {
            System.out.println("������Ҫ��ӵ�ѧ�ţ�");
            id = input1.nextLine();
            checkId = repeatId(array, id);
            if(checkId)
            {
                System.out.println("ѧ���ظ�������������");
            }
            else
            {
                break;
            }
        }
        
        System.out.println("������Ҫ��ӵ�������");
        String name = input1.nextLine();

        System.out.println("������Ҫ��ӵ����䣺");
        String age = input1.nextLine();
        
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);

        array.add(s);
    }

    //��ѯ����
    public static void checkStudent(ArrayList<Student> array)
    {
        if(array.size() == 0)
        {
            System.out.println("������Ϣ������Ӻ��ѯ��\n");
            return;
        }
        
        System.out.println("ѧ��\t����\t����");
        for(int i = 0; i < array.size(); i++)
        {
            Student s = array.get(i);
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge());
        }
    }

    //ɾ������
    public static void deleteStudent(ArrayList<Student> array)
    {
        Scanner input2 = new Scanner(System.in);
        System.out.println("������Ҫɾ����ѧ����ѧ�ţ�");
        String delete = input2.nextLine();
        int index = -1;

        for(int i = 0; i < array.size(); i++)
        {
            Student s = array.get(i);
           if(delete.equals(s.getId()))
           {
                index = i;
           }
        }
        
        if(index == -1)
        {
            System.out.println("δ�ҵ���ѧ����������");
        }
        else
        {
            array.remove(index);
            System.out.println("ɾ���ɹ�");
        }
    }

    //�޸ķ���
    public static void modifyStudent(ArrayList<Student> array)
    {
        Scanner input3 = new Scanner(System.in);
        System.out.println("������Ҫ�޸ĵ�ѧ����ѧ�ţ�");
        
        String oldId = input3.nextLine();
        String newId;
        String newName;
        String newAge;

        for(int i = 0; i < array.size(); i++)
        {
            Student s = array.get(i);
            if(oldId.equals(s.getId()))
            {
                System.out.println("�Ѳ��ҵ����û�");
                System.out.println("������ѧ����ѧ�ţ�");
                newId = input3.nextLine();
                System.out.println("������ѧ�������֣�");
                newName = input3.nextLine();
                System.out.println("������ѧ�������䣺");
                newAge = input3.nextLine();
                s.setId(newId);
                s.setName(newName);
                s.setAge(newAge);
                System.out.println("�޸ĳɹ�");
            }
            else
            {
                System.out.println("δ�ҵ���ѧ����������");
            }
        }
    }

    //�ظ�Id���
    public static boolean repeatId(ArrayList<Student> array, String id)
    {
        boolean flag = false;
        for(int i = 0; i < array.size(); i++)
        {
            Student s = array.get(i);
            if(id.equals(s.getId()))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }
}