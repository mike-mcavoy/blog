import { useEffect } from "react";
import { ENV } from "../../config/env";

function HomePage() {
  useEffect(() => {
    fetch(`${ENV.API_BASE_URL}/posts`)
      .then((response) => response.text())
      .then((body) => console.log(body));
  }, []);

  return <h1>Home</h1>;
}

export default HomePage;
