# 2) Writing entities
First of all, we need some data. We need to write internal entities for all the classes we want to 
expose and represent through our API.

The internal model can differ from the external model in many cases. The internal model must be 
written to represent and support the data model you require internally as a primary objective. 
For instance, you may not want to expose every field in a model in the API. 

However, for this course, we will want a 1:1 representation between the internal and the external model
for simplicity. 

## Finish the Pet model
I have written a nearly empty class to get ut started, it is located at `no.netcompany.edu.springboot.model.Pet`.

Finish this class by adding all the data described in the transport model, which you can find in
`target/classes/no/netcompany/edu/springboot/api/model/PetDto.class` or by looking at the swagger file. 

Note: For now, the `Category` field can be a String, and you can ignore Tags and PhotoUrls. 

