# 3) Converting entities
When we are dealing with APIs and transport models, we need a way to convert between
our external and internal representations. There are many ways of doing this, but we
will rely on the Factory method. 

## Complete the PetFactory class
At `no.netcompany.edu.springboot.factory.PetFactory` there is an incomplete factory method for converting
from `Pet` to `PetDto`. Finish this method by adding functionality to set all the values
we need exposed in the transport model. 

## Test it!
Now we are going to start approaching test driven development (TDD). All essential functionality needs to be tested,
and in this case you are to add tests to the PetFactory. The skeleton is located at 
`src/test/java/no/netcompany/edu/springboot/factory/PetFactoryTest.java`. You can see a basic
example of a tested class in `src/test/java/no/netcompany/edu/springboot/service/PetServiceTest.java`.

