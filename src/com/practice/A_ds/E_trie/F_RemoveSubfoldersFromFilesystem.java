package com.practice.A_ds.E_trie;
import java.util.*;

/**
 * Created by prathapchowdary on 13/11/24.
 *
 * Given a list of folders folder, return the folders after removing all sub-folders in those folders.
 * You may return the answer in any order.
 *
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 *
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
 */
public class F_RemoveSubfoldersFromFilesystem {
    Trie root = null;
    List<String> result = null;
    public List<String> removeSubfolders(String[] folder) {
        result = new ArrayList<>();
        buildTrieStructure(folder);
        removeSubfolders(root, new StringBuilder(""));
        return result;
    }

    private void buildTrieStructure(String[] folder) {
        //add dummy root node
        root = new Trie("/");
        root.subFolders = new HashMap<>();
        for (String f : folder) {
            addFolderToTrie(f);
        }
    }

    private void addFolderToTrie(String folderPath) {
        String[] folderNames = folderPath.split("//");
        Trie node = root;
        for (int i=0; i<folderNames.length; i++) {
            String currFolder= folderNames[i];
            if (node.subFolders.containsKey(currFolder)) {
                node = node.subFolders.get(currFolder);
            } else {
                Trie temp = new Trie(currFolder);
                node.subFolders.put(currFolder, temp);
            }
            //leaf folder
            if (i == folderNames.length-1) {
                node.isLeaf = true;
            }
        }
    }

    private void removeSubfolders(Trie node, StringBuilder path) {
        //Trie node = root.subFolders.get();
        //StringBuilder path = new StringBuilder("");
        while (node != null) {
            Map<String, Trie> subFolders = node.subFolders;
            for (Map.Entry<String, Trie> subFolderEntry : subFolders.entrySet()) {
                Trie subFolder = subFolderEntry.getValue();
                if (!subFolder.isLeaf) {
                    path.append("/");
                    path.append(subFolder.folderName);
                    result.add(path.toString());
                } else {
                    removeSubfolders(subFolder, path);
                }
            }
        }
    }

    class Trie {
        String folderName;
        boolean isLeaf;
        Map<String, Trie> subFolders;
        public Trie(String folderName) {
            this.folderName = folderName;
        }
    }
}
