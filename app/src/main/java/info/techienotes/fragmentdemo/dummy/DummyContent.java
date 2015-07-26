package info.techienotes.fragmentdemo.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContent {
    //ArrayList of DummyItems
    public List<DummyItem> ITEM_LIST= new ArrayList<DummyItem>();

    //Map of DummyItems with ID
    public Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    public DummyContent(){
        addItem(new DummyItem("1", "One"));
        addItem(new DummyItem("2", "Two"));
        addItem(new DummyItem("3", "Three"));
        addItem(new DummyItem("4", "Four"));
        addItem(new DummyItem("5", "Five"));
    }

    private void addItem(DummyItem item) {
        ITEM_LIST.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public List getItemList(){
        return ITEM_LIST;
    }

    public Map getItemMappings(){
        return ITEM_MAP;
    }

    //  A dummy item representing an entry in the list
    public class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }

        public String getContent(){
            return content;
        }

        public String getId(){
            return id;
        }
    }
}
