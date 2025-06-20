import { useEffect, useState } from "react";
import { ENV } from "../../config/env";

type Post = {
  slug: string;
  created: string;
  html: string;
};

function HomePage() {
  const [posts, setPosts] = useState<Post[]>([]);

  useEffect(() => {
    fetch(`${ENV.API_BASE_URL}/posts`)
      .then((response) => response.json())
      .then((data) => {
        setPosts(data);
      });
  }, []);

  return (
    <div>
      <h1>Home</h1>
      <ul>{posts.length && posts.map((post) => <li>{post.slug}</li>)}</ul>
    </div>
  );
}

export default HomePage;
