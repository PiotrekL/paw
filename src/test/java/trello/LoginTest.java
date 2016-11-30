package trello;

import static org.junit.Assert.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import trello.service.BoardService;

public class LoginTest extends JerseyTest {
	 
 
    @Override
    protected Application configure() {
        return new ResourceConfig(BoardService.class);
    }
    
    
    
 
    @Test
    public void test() {
        final Response hello = target("boards/deleteBoard/4").request().delete();
        System.out.print(hello.getStatus());
        assertEquals(204, hello.getStatus());
    }
}