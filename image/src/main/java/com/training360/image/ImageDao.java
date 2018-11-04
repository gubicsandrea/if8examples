package com.training360.image;

import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ImageDao {

    private JdbcTemplate jdbcTemplate;

    public ImageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Image getImage(long id) {
        Image image = jdbcTemplate.queryForObject("select id, image_file, file_type, file_name from images where id = ?", new ImageRowMapper(), id);
        return image;
    }

    public void saveImage(Image image) {
        try {
            if (image.getId() == 0) {
                jdbcTemplate.update("insert into images (image_file, file_type, file_name) values (?, ?, ?);", image.getFileBytes(), image.getMediaType().toString(), image.getFileName());
            } else {
                jdbcTemplate.update("update images set image_file = ?, file_type = ?, file_name = ? where id = ?", image.getFileBytes(), image.getMediaType().toString(), image.getFileName(), image.getId());
            }
        } catch (DataAccessException daex) {
            throw new IllegalArgumentException("Cannot save image", daex);
        }
    }

    private static class ImageRowMapper implements RowMapper<Image> {
        @Override
        public Image mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            byte[] imageBytes = resultSet.getBytes("image_file");
            MediaType mediaType = MediaType.parseMediaType(resultSet.getString("file_type"));
            String fileName = resultSet.getString("file_name");
            return new Image(id, imageBytes, mediaType, fileName);
        }
    }
}
