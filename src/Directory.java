import java.util.ArrayList;

public class Directory extends Entry {
    protected ArrayList<Entry> contents; // Using arraylist to preserve creation order

    public Directory(String name, Directory parent) {
        super(name, parent);
        contents = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        Entry contentToCreate = findContentByName(entry.name);
        if(contentToCreate != null) {
            System.out.println("Directory already exists");
        } else {
            contents.add(entry);
        }
    }

    protected ArrayList<Entry> getContents() {
        return contents;
    }

    protected void printContents() {
        contents.forEach(System.out::println);
    }

    protected void printContentsRecursively() {
        for(Entry content: contents) {
            if(content instanceof Directory) {
                System.out.println(content.printDirectoryPath());
                ((Directory)content).printContentsRecursively();
            } else {
                System.out.println(content);
            }
        }
    }

    protected Entry findContentByName(String name) {
        if(name == null) {
            return null;
        }
        for(Entry content: contents) {
            if(name.equals(content.getName())) {
                return content;
            }
        }
        return null;
    }
}
