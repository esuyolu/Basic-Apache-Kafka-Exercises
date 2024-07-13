public class TweetModel {
    private String user_name;
    private String user_location;
    private String user_description;
    private String user_created;
    private String user_followers;
    private String user_friends;
    private String user_favourites;
    private String user_verified;
    private String date;
    private String text;
    private String source;
    private String is_retweet;

    public TweetModel() {
    }

    public TweetModel(String user_name, String user_location, String user_description, String user_created, String user_followers, String user_friends, String user_favourites, String user_verified, String date, String text, String source, String is_retweet) {
        this.user_name = user_name;
        this.user_location = user_location;
        this.user_description = user_description;
        this.user_created = user_created;
        this.user_followers = user_followers;
        this.user_friends = user_friends;
        this.user_favourites = user_favourites;
        this.user_verified = user_verified;
        this.date = date;
        this.text = text;
        this.source = source;
        this.is_retweet = is_retweet;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public String getUser_description() {
        return user_description;
    }

    public void setUser_description(String user_description) {
        this.user_description = user_description;
    }

    public String getUser_created() {
        return user_created;
    }

    public void setUser_created(String user_created) {
        this.user_created = user_created;
    }

    public String getUser_followers() {
        return user_followers;
    }

    public void setUser_followers(String user_followers) {
        this.user_followers = user_followers;
    }

    public String getUser_friends() {
        return user_friends;
    }

    public void setUser_friends(String user_friends) {
        this.user_friends = user_friends;
    }

    public String getUser_favourites() {
        return user_favourites;
    }

    public void setUser_favourites(String user_favourites) {
        this.user_favourites = user_favourites;
    }

    public String getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(String user_verified) {
        this.user_verified = user_verified;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIs_retweet() {
        return is_retweet;
    }

    public void setIs_retweet(String is_retweet) {
        this.is_retweet = is_retweet;
    }

    @Override
    public String toString() {
        return "TweetModel{" +
                "user_name='" + user_name + '\'' +
                ", user_followers='" + user_followers + '\'' +
                ", user_friends='" + user_friends + '\'' +
                ", user_favourites='" + user_favourites + '\'' +
                '}';
    }
}
