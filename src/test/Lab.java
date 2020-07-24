import com.dayary.elly.common.tool.BCRYPT;

public class Lab {

	public static void main(String[] args) {
		
		String pw = BCRYPT.hashpw("user1");
		System.out.println(pw);

	}

}
