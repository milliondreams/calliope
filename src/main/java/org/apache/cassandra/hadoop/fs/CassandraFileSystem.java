package org.apache.cassandra.hadoop.fs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;

public class CassandraFileSystem extends FileSystem {

    private static final Logger logger = LoggerFactory.getLogger(CassandraFileSystem.class);

    public CassandraFileSystemStore store;
    private URI uri;
    private Path workingDir;
    private long subBlockSize;

    public CassandraFileSystem() {
        this.store = new CassandraFileSystemThriftStore();
    }


    public void initialize(URI uri, Configuration conf) throws IOException {

        super.initialize(uri, conf);

        setConf(conf);
        this.uri = URI.create(uri.getScheme() + "://" + uri.getAuthority());
        this.workingDir = new Path("/user", System.getProperty("user.name")).makeQualified(this);

        logger.info(this.workingDir.toString());
        store.initialize(this.uri, conf);

        subBlockSize = conf.getLong("fs.local.subblock.size", 256L * 1024L);
    }

    @Override
    public URI getUri() {
        return this.uri;
    }

    @Override
    public FSDataInputStream open(Path path, int i) throws IOException {

    }

    @Override
    public FSDataOutputStream create(Path path, FsPermission fsPermission, boolean b, int i, short i2, long l, Progressable progressable) throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public FSDataOutputStream append(Path path, int i, Progressable progressable) throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean rename(Path path, Path path2) throws IOException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Path path) throws IOException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Path path, boolean b) throws IOException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public FileStatus[] listStatus(Path path) throws IOException {
        return new FileStatus[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setWorkingDirectory(Path path) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Path getWorkingDirectory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean mkdirs(Path path, FsPermission fsPermission) throws IOException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public FileStatus getFileStatus(Path path) throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
