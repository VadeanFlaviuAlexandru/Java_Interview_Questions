package RandomTestFoundOnline.SectionOne;

class SocialMediaPost {
    private String content;
    private String author;
    private String platform;
    private boolean isPublic;

    public SocialMediaPost(String content, String author, String platform, boolean isPublic) {
        this.content = content;
        this.author = author;
        this.platform = platform;
        this.isPublic = isPublic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getSummary() {
        return content.substring(0, Math.min(content.length(), 50));
    }

    public void toggleVisibility() {
        isPublic = !isPublic;
    }
}

class ImagePost extends SocialMediaPost {
    private String imageUrl;

    public ImagePost(String content, String author, String platform, boolean isPublic, String imageUrl) {
        super(content, author, platform, isPublic);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

class VideoPost extends SocialMediaPost {
    private String videoUrl;
    private boolean isPaused = false;

    public VideoPost(String content, String author, String platform, boolean isPublic, String videoUrl) {
        super(content, author, platform, isPublic);
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void playResume() {
        if (isPaused) {
            isPaused = false;
        } else {
            isPaused = true;
        }
    }

}
