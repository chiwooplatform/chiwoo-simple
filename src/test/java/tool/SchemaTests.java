package tool;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import org.chiwooplatform.simple.AbstractMapperTests;
import org.junit.Test;

public class SchemaTests
    extends AbstractMapperTests<Object> {

    @Autowired
    private DataSource dataSource;

    /**
     * 테이블 드랍
     * @throws Exception
     */
    @Test
    @Sql(scripts = { "/schema-drop.ddl" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    public void testDropSchema()
        throws Exception {
        logger.info( "dataSource: {}", dataSource );
    }

    /**
     * 테이블 생성
     * @throws Exception
     */
    @Test
    @Sql(scripts = { "/schema.ddl" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    public void testCreateSchema()
        throws Exception {
        logger.info( "dataSource: {}", dataSource );
    }

    /**
     * 기초 데이타 적재
     * @throws Exception
     */
    @Test
    @Rollback(false)
    @Sql(value = { "/schema-imports.sql" })
    public void testLoadData()
        throws Exception {
        logger.info( "dataSource: {}", dataSource );
    }

    
    @Test
    public void allCleanAndReCreation()
        throws Exception {
        this.testDropSchema();
        this.testCreateSchema();
        this.testLoadData();
    }
    
    /**
     * @see org.chiwooplatform.simple.AbstractMapperTests#model()
     */
    @Override
    protected Object model() {
        return null;
    }
}
