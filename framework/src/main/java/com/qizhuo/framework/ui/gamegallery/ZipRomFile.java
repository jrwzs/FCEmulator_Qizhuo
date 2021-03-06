package com.qizhuo.framework.ui.gamegallery;

import java.io.File;
import java.util.ArrayList;

import com.qizhuo.framework.gamedata.dao.entity.GameEntity;
import com.qizhuo.framework.utils.annotations.Column;
import com.qizhuo.framework.utils.annotations.ObjectFromOtherTable;
import com.qizhuo.framework.utils.annotations.Table;

@Table
public class ZipRomFile {

    @Column(isPrimaryKey = true)
    public long _id;

    @Column
    public String hash;

    @Column
    public String path;

    @ObjectFromOtherTable(columnName = "zipfile_id")
    public ArrayList<GameEntity> games = new ArrayList<>();

    public ZipRomFile() {
    }

    public static String computeZipHash(File zipFile) {
        return zipFile.getAbsolutePath().concat("-" + zipFile.length()).hashCode() + "";
    }
}
