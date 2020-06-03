
public class BaiduSearchPage {
    public static final Logger LOG = LoggerFactory
        .getLogger(BaiduSearchPage.class);
    private WebElement wd;
 
    public void searchFor(String keyword) {
        wd.sendKeys(keyword);
        wd.submit();
    }
 
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.baidu.com");
        BaiduSearchPage baiduPage = PageFactory.initElements(driver,
            BaiduSearchPage.class);
        LOG.info("before search url is:{}",driver.getCurrentUrl());
        baiduPage.searchFor("blueshen");
        LOG.info("after search url is:{}",driver.getCurrentUrl());
    }
}


