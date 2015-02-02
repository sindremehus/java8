package no.scienta.lambada.mediafile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class VideoFilter {

    public List<MediaFile> filterVideos0(List<MediaFile> files) {
        List<MediaFile> result = new ArrayList<>();
        for (MediaFile file : files) {  // Note IntelliJ intention
            if (file.isVideo()) {
                result.add(file);
            }
        }
        return result;
    }

    public List<MediaFile> filterVideos1(List<MediaFile> files) {
        return files.stream().filter(mediaFile -> mediaFile.isVideo()).collect(Collectors.toList());
    }

    public List<MediaFile> filterVideos2(List<MediaFile> files) {
        return files.stream().filter(MediaFile::isVideo).collect(Collectors.toList());
    }

    public List<MediaFile> filterVideos3(List<MediaFile> files) {
        return filter(files, MediaFile::isVideo);
    }

    public Stream<MediaFile> filterVideos4(Stream<MediaFile> files) {
        return files.filter(MediaFile::isVideo);
    }

    public static <T> List<T> filter(List<T> in, Predicate<T> predicate) {
        return in.stream().filter(predicate).collect(Collectors.toList());
    }
}
