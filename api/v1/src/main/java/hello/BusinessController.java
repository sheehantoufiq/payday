package hello;


@RestController
public class BusinessController {

	// Get businesses
	@RequestMapping( value = "/api/businesses/dummy", method = RequestMethod.GET )
	public Business getDummy() {

		Business b = new Business();
		b.setId(9999);
		b.setName("Business Name");
		b.setAddress("555 Main St");
		b.setCity("Atlanta");
		b.setState("GA");
		b.setZip("30303");
		b.setPhone("555-555-5555");
		return b;

	}

	// Get business
	//@RequestMapping( value = URIConstants.URI_BUSINESS, method = RequestMethod.GET )
	//public Business get(@PathVariable String businessID) {}

	// Update business
	//@RequestMapping( value = URIConstants.URI_BUSINESS, method = RequestMethod.PUT )
	//public Business update(@PathVariable String businessID) {}
}