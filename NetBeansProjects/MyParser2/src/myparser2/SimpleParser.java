
package myparser2;


public class SimpleParser extends ComLineParserBase{
    private String inFile,outFile;

    public String getInFile()  {return inFile;}

    public String getOutFile() {return outFile;}
    
    public SimpleParser() {
        super(new String[]{"?","r","w"});
    }
    @Override
    protected void OnUsage(String errorKey){         
        if (errorKey != null)
            System.out.println("Command-line switch error:" + errorKey);

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
	System.out.println("   -?  показать Help файл");
	System.out.println("   -r  задать имя входного файла");
	System.out.println("   -w  выполнить вывод в указанный файл");
    }
    
    
}
