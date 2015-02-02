package no.scienta.lambada.mediafile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class MediaFileIdMapper {

    public List<Integer> getMediaFileIds0(List<MediaFile> files) {
        List<Integer> result = new ArrayList<>();
        for (MediaFile file : files) {
            result.add(file.getId());
        }
        return result;
    }

    public List<Integer> getMediaFileIds1(List<MediaFile> files) {
        return files.stream().map(MediaFile::getId).collect(Collectors.toList());
    }

    public List<Integer> getMediaFileIds2(List<MediaFile> files) {
        return map(files, MediaFile::getId);
    }

    public Stream<Integer> getMediaFileIds3(Stream<MediaFile> files) {
        return files.map(MediaFile::getId);
    }

    public static <T, R> List<R> map(List<T> in, Function<T, R> mapper) {
        return in.stream().map(mapper).collect(Collectors.toList());
    }

}
