package javaTester;

public class topic_03_Get_Sys_Info {
    public static void main(String args[]){
        String osName = System.getProperty("os.name");
        System.out.println(osName);
    }
}
