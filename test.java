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
            System.out.println("-------学生管理系统-------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询所有学生");
            System.out.println("5.退出");
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
                System.out.println("请输入 1 到 5 的数字：\n");
            }
            else
            {
                switch(select)
                {
                    case 1 :
                    System.out.println("《添加学生》");
                    addStudent(array);
                    break;
                    case 2 :
                    System.out.println("《删除学生》");
                    deleteStudent(array);
                    break;
                    case 3 :
                    System.out.println("《修改学生》");
                    modifyStudent(array);
                    break;
                    case 4 :
                    System.out.println("《查询所有学生》");
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
    //添加方法
    public static void addStudent(ArrayList<Student> array)
    {
        Scanner input1 = new Scanner(System.in);
        boolean checkId = false;
        String id;

        //检查id是否重复
        while(true)
        {
            System.out.println("请输入要添加的学号：");
            id = input1.nextLine();
            checkId = repeatId(array, id);
            if(checkId)
            {
                System.out.println("学号重复，请重新输入");
            }
            else
            {
                break;
            }
        }
        
        System.out.println("请输入要添加的姓名：");
        String name = input1.nextLine();

        System.out.println("请输入要添加的年龄：");
        String age = input1.nextLine();
        
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);

        array.add(s);
    }

    //查询方法
    public static void checkStudent(ArrayList<Student> array)
    {
        if(array.size() == 0)
        {
            System.out.println("暂无信息，请添加后查询！\n");
            return;
        }
        
        System.out.println("学号\t姓名\t年龄");
        for(int i = 0; i < array.size(); i++)
        {
            Student s = array.get(i);
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge());
        }
    }

    //删除方法
    public static void deleteStudent(ArrayList<Student> array)
    {
        Scanner input2 = new Scanner(System.in);
        System.out.println("请输入要删除的学生的学号：");
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
            System.out.println("未找到该学生，请重试");
        }
        else
        {
            array.remove(index);
            System.out.println("删除成功");
        }
    }

    //修改方法
    public static void modifyStudent(ArrayList<Student> array)
    {
        Scanner input3 = new Scanner(System.in);
        System.out.println("请输入要修改的学生的学号：");
        
        String oldId = input3.nextLine();
        String newId;
        String newName;
        String newAge;

        for(int i = 0; i < array.size(); i++)
        {
            Student s = array.get(i);
            if(oldId.equals(s.getId()))
            {
                System.out.println("已查找到该用户");
                System.out.println("请输入学生新学号：");
                newId = input3.nextLine();
                System.out.println("请输入学生新名字：");
                newName = input3.nextLine();
                System.out.println("请输入学生新年龄：");
                newAge = input3.nextLine();
                s.setId(newId);
                s.setName(newName);
                s.setAge(newAge);
                System.out.println("修改成功");
            }
            else
            {
                System.out.println("未找到该学生，请重试");
            }
        }
    }

    //重复Id检查
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