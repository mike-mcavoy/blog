import { NavLink, Outlet } from "react-router";

function Layout() {
  return (
    <div>
      <NavLink
        to="/"
        style={({ isActive }) => {
          return {
            color: isActive ? "coral" : "black",
          };
        }}
      >
        Home
      </NavLink>
      <NavLink
        to="/blog"
        style={({ isActive }) => {
          return {
            color: isActive ? "coral" : "black",
          };
        }}
      >
        Blog
      </NavLink>
      <Outlet />
    </div>
  );
}

export default Layout;
