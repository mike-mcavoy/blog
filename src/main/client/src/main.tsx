import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router";

import { HomePage } from "./pages/Home";
import { BlogPage } from "./pages/Blog";
import Root from "./pages/Layout";

const router = createBrowserRouter([
  {
    Component: Root,
    children: [
      {
        path: "/",
        Component: HomePage,
      },
      { path: "/blog", Component: BlogPage },
    ],
  },
]);

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
);
