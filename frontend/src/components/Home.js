import { makeStyles } from "@material-ui/core/styles";
import Box from "@mui/material/Box";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import React from "react";
import Author from "../blogs/Author";
import Blog from "../blogs/Blog";
import Header from "../pages/header";

const useStyle = makeStyles((theme) => ({
  home: {
    flexGrow: 1,
    margin: 80,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary,
  },
  card: {
    maxWidth: "100%",
  },
}));

export default function Home() {
  const classes = useStyle();
  return (
    <div>
      <Header />

      <div className={classes.home}>
        <Container fixed>
          <Box sx={{ flexGrow: 1 }} marginTop="100">
            <Grid container spacing={2}>
              <Grid item xs={4}>
                <Author />
              </Grid>
              <Grid item xs={8}>
                <Blog />
              </Grid>
            </Grid>
          </Box>
        </Container>
      </div>
    </div>
  );
}
