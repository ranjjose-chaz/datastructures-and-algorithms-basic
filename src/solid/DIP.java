//                      ******************** DEPENDENCY INVERSION PRINCIPLE ********************
//A.    High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g. interfaces).
//B.    Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.

package solid;

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DIP {

    public static void main(String[] args){
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");
        Person grandParent = new Person("Mathew");
        Person aunt = new Person("Jessie");
        Person jeff = new Person("Paul");


        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent,child1);
        relationships.addParentAndChild(parent,child2);

        Research research = new Research(relationships);

        RelationShips2 relationShips2 = new RelationShips2();
        relationShips2.addRelations(parent, RelationshipType.PARENT, new Person("Kevin"));
        relationShips2.addRelations(parent, RelationshipType.PARENT, new Person("Ron"));
        relationShips2.addRelations(grandParent, RelationshipType.GRANDPARENT, child1);
        relationShips2.addRelations(grandParent, RelationshipType.GRANDPARENT, child2);
        relationShips2.addRelations(aunt, RelationshipType.AUNT, child1);
        relationShips2.addRelations(aunt, RelationshipType.AUNT, child2);
        relationShips2.addRelations(jeff, RelationshipType.COUSIN, grandParent);

        research = new Research(relationShips2);
    }


}



enum RelationshipType {
    PARENT,
    CHILD,
    SIBLING,
    UNCLE,
    AUNT,
    COUSIN,
    GRANDPARENT
}



class Person {
    public String name;
    public Person(String name){
        this.name =name;
    }
}

class Relationships implements RelationshipBrowser{
    private List<Triplet<Person, RelationshipType, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, RelationshipType, Person>> getRelations(){
        return relations;
    }

    public void addParentAndChild(Person parent, Person child){
        relations.add(new Triplet<>(parent, RelationshipType.PARENT, child));
        relations.add(new Triplet<>(child, RelationshipType.CHILD, parent));

    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream().filter( x -> Objects.equals(x.getValue0().name, name)
                && x.getValue1() == RelationshipType.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}


class Relation {

    Person person1;
    RelationshipType relationshipType;
    Person person2;

    public Relation(Person person1, RelationshipType relationshipType, Person person2){
        this.person1 = person1;
        this.relationshipType = relationshipType;
        this.person2 = person2;
    }

}

class RelationShips2 implements RelationshipBrowser {

    List<Relation> relations = new ArrayList<>();

    public void addRelations(Person p1, RelationshipType type, Person p2) {
        relations.add(new Relation(p1, type, p2));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream().filter( x -> Objects.equals(x.person1.name, name)
                && x.relationshipType == RelationshipType.PARENT)
                .map(x -> x.person2)
                .collect(Collectors.toList());
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}



class Research{

    /**
     * This is an example of violation of dependency inversion principle
     */
    public Research(solid.Relationships relationships){
        List<Triplet<solid.Person, solid.RelationshipType, solid.Person>> relations = relationships.getRelations();
        relations.stream()
                .filter(x -> x.getValue0().name.equals("John") && x.getValue1() == solid.RelationshipType.PARENT)
                .forEach(ch -> System.out.println(
                        "John has a child called "+ch.getValue2().name
                ));

    }

    public Research(RelationshipBrowser browser){

        List<Person> childrenOfJohn = browser.findAllChildrenOf("John");
        for(Person chid: childrenOfJohn)
            System.out.println("John has a child called " + chid.name);

    }
}

