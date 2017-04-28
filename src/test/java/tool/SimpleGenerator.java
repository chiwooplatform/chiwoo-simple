package tool;

import org.chiwooplatform.gen.AbstractGenerator;
import org.chiwooplatform.gen.CodeTypes.DBMS;
import org.junit.Test;

public class SimpleGenerator
    extends AbstractGenerator {

    @Test
    public void generateSqlMapper()
        throws Exception {
        generator.generateSqlMapper();
    }
    
    @Test
    public void generateAll()
        throws Exception {
        generator.generateAll();
    }

    @Test
    public void generateDAM()
        throws Exception {
        generator.generateDAM();
    }

    protected boolean generateRealPath() {
        return true;
    }

    protected DBMS dbms() {
        return DBMS.MARIADB;
    }

    protected String permissionGroup() {
        return "API";
    }

    protected String tableName() {
        return "COM_CODE";
    }

    protected String pkgName() {
        return "com";
    }

    protected String modelName() {
        return "Code";
    }

    protected String serviceName() {
        return "CommonService";
    }
}
