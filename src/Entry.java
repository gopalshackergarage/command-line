public abstract class Entry {
    protected Directory parent;
    protected String name;

    public Entry(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public boolean delete() {
        if (parent == null) {
            return false;
        }
        return parent.deleteEntry(this);
    }

    public void changeName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public String printDirectoryPath() {
        if (parent == null) {
            return "/root";
        }
        return parent.printDirectoryPath() + "/" + ((this instanceof Directory) ? this.name : "");
    }

    @Override
    public String toString() {
        return this.name;
    }
}

