package spring.aop07;

import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;


@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
	
	//	value为xml文件中的types-matching
	//	defaultImpl为default-impl,delegate-ref(default-impl填写完整类名，delegate-ref为spring的bean引用)
	//	teacher 为  implement-interface
	@DeclareParents(value="spring.aop07.Mother+",defaultImpl=People2.class)
	public static Teacher teacher;
}
