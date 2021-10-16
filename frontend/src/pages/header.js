import * as React from "react";
import { NavLink } from "react-router-dom";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import Container from "@material-ui/core/Container";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    // marginInline: 360.5,
  },
  title: {
    flexGrow: 1,
  },
  button: {
    "& > *": {
      margin: theme.spacing(1),
    },
  },
}));

function Header(props) {
  const classes = useStyles();

  return (
    <Container fixed>
      <AppBar position="static" AppBar>
        <Toolbar>
          <Typography variant="h6" className={classes.title}>
            Dentail
          </Typography>
          <nav>
            <div className={classes.button}>
              <NavLink to="/home" style={{ textDecoration: "none" }} exact>
                <Button
                  variant="contained"
                  color="primary"
                  href="#contained-buttons"
                >
                  Home
                </Button>
              </NavLink>

              <NavLink to="/about" style={{ textDecoration: "none" }} exact>
                <Button
                  variant="contained"
                  color="primary"
                  href="#contained-buttons"
                >
                  About
                </Button>
              </NavLink>
              <NavLink to="/contact/1" style={{ textDecoration: "none" }} exact>
                <Button
                  variant="contained"
                  color="primary"
                  href="#contained-buttons"
                >
                  Contact
                </Button>
              </NavLink>
            </div>
          </nav>
        </Toolbar>
      </AppBar>
    </Container>
  );
}

export default Header;
