package bean;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MybatisModelGenerator {

    final private static String CONFIG = "generator/mapperConfig.xml";
    final private static boolean OVERWRITE = true;

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();

        ConfigurationParser cp = new ConfigurationParser(warnings);
        InputStream in = Object.class.getResourceAsStream(CONFIG);
        Configuration configuration = cp.parseConfiguration(Object.class.getResourceAsStream(CONFIG));

        DefaultShellCallback callback = new DefaultShellCallback(OVERWRITE);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
