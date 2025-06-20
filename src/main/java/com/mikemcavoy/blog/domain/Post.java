package com.mikemcavoy.blog.domain;

public class Post {
    private final String slug;
    private final String created;
    private final String html;

    private Post(Builder builder) {
        this.slug = builder.slug;
        this.created = builder.created;
        this.html = builder.html;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getSlug() {
        return slug;
    }

    public String getCreated() {
        return created;
    }

    public String getHtml() {
        return html;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((slug == null) ? 0 : slug.hashCode());
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((html == null) ? 0 : html.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (slug == null) {
            if (other.slug != null)
                return false;
        } else if (!slug.equals(other.slug))
            return false;
        if (created == null) {
            if (other.created != null)
                return false;
        } else if (!created.equals(other.created))
            return false;
        if (html == null) {
            if (other.html != null)
                return false;
        } else if (!html.equals(other.html))
            return false;
        return true;
    }

    public static class Builder {
        private String slug;
        private String created;
        private String html;

        public Builder slug(String slug) {
            this.slug = slug;
            return this;
        }

        public Builder created(String created) {
            this.created = created;
            return this;
        }

        public Builder html(String html) {
            this.html = html;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }
}
