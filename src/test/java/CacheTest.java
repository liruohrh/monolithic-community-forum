import com.liruo.communityforum.App;
import com.liruo.communityforum.controller.VerificationCodeController;
import com.liruo.communityforum.model.dto.VerificationCodeReq;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author:liruo
 * @Date:2023-06-18-15:34:28
 * @Desc
 */
@SpringBootTest(classes = App.class)
public class CacheTest {
  @Resource
  private VerificationCodeController verificationCodeController;
  @Test
  public void test() {
    VerificationCodeReq req = new VerificationCodeReq();
    req.setType("type");
    req.setAction("action");
    req.setTarget("target");
//    System.out.println(verificationCodeController.verify(req));
//    System.out.println(verificationCodeController.verify(req));

  }
}
