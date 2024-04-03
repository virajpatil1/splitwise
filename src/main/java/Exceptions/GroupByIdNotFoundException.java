package Exceptions;

public class GroupByIdNotFoundException extends RuntimeException{

    public GroupByIdNotFoundException(Long groupId) {
        super(
                "Group by particular given Id is not found pls check : "+groupId
        );
    }
}
