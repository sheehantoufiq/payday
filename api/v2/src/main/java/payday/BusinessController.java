package payday;

//import java.util.concurrent.atomic.AtomicLong;
import java.text.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class BusinessController {
	/*
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    */

    //Business currentBusiness = new Business(1, "Payday, Inc", "555 Main St", "Atlanta", "GA", "30303", "555-555-5555");

    // Get dummy business
	@RequestMapping( value = "/api/businesses/dummy", method = RequestMethod.GET )
	public Business getDummy() {

		return new Business(9999, "Business Name", "555 Main St", "Atlanta", "GA", "30303", "555-555-5555");
	}

    @RequestMapping( value = "/api/businesses/1", method = RequestMethod.GET )
    public Business get() {
        Business currentBusiness = BusinessService.getBusiness(1);
        return currentBusiness;
    }

    @RequestMapping( value = "/api/businesses/1", method = RequestMethod.PUT )
    public Business update(     
        @RequestParam(value="name", required=true) String name, 
        @RequestParam(value="add", required=true) String add, 
        @RequestParam(value="city", required=true) String city, 
        @RequestParam(value="state", required=true) String state,
        @RequestParam(value="zip", required=true) String zip,
        @RequestParam(value="phone", required=true) String phone) throws ParseException
    {
        Business business = new Business();
        
        business.setId(1);        
        business.setName(name);
        business.setAddress(add);
        business.setCity(city);
        business.setState(state);
        business.setZip(zip);
        business.setPhone(phone);

        BusinessService.updateBusiness(business);
        return business;
    }
}