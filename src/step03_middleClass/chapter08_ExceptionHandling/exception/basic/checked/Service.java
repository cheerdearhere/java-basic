package step03_middleClass.chapter08_ExceptionHandling.exception.basic.checked;

public class Service {
    Client client = new Client();

    /**
     * catch MyCheckedException
     */
    public void callCatch(){
        try{
            client.call();
        }
        catch (MyCheckedException me){
            System.out.println("예외 처리, message: "+me.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("정상 흐름");
    }

    /**
     * throw MyCheckedException
     * @throws MyCheckedException
     */
    public void callThrows() throws MyCheckedException{
        client.call();
    }

}
