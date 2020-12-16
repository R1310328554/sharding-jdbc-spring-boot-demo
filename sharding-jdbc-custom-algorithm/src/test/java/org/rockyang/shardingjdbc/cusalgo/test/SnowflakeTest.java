package org.rockyang.shardingjdbc.cusalgo.test;

import org.junit.Test;
import org.rockyang.shardingjdbc.common.utils.Snowflake;

/**
 * @author l.k
 */
public class SnowflakeTest {

	@Test
	public void test()
	{
		for (int i = 0; i < 1000; i++) {
			System.out.println(Snowflake.getInstance().nextId());
		}
	}
}
