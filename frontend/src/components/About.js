import { makeStyles } from "@material-ui/core/styles";
import Box from "@mui/material/Box";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import Typography from "@mui/material/Typography";
import React from "react";
import Author from "../blogs/Author";
import { Link, useParams } from "react-router-dom";
import Button from "@material-ui/core/Button";

import Header from "../pages/header";

const useStyle = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    margin: 80,
    textAlign: "left",
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: "left",
    color: theme.palette.text.secondary,
  },
}));

export default function About() {
  const classes = useStyle();
  return (
    <div>
      <Header />

      <div className={classes.root}>
        <Container fixed>
          <Box sx={{ flexGrow: 1 }} marginTop="100">
            <Grid container spacing={2}>
              <Grid item xs={4}>
                <Author />
              </Grid>
              <Grid item xs={8}>
                <Paper className={classes.paper}>
                  <Grid container spacing={2}>
                    <Grid item xs={12} sm container>
                      <Grid item xs container direction="column" spacing={2}>
                        <Grid item xs>
                          <Typography gutterBottom variant="h4" component="div">
                            About Me
                          </Typography>
                          <Typography variant="body2" gutterBottom>
                            The rich text element allows you to create and
                            format headings, paragraphs, blockquotes, images,
                            and video all in one place instead of having to add
                            and format them individually. Just double-click and
                            easily create content.
                          </Typography>
                          <Typography gutterBottom variant="h4" component="div">
                            Something else here
                          </Typography>
                          <Typography variant="body2" gutterBottom>
                            This is some dummy copy. You’re not really supposed
                            to read this dummy copy, it is just a place holder
                            for people who need some type to visualize what the
                            actual copy might look like if it were real content.
                            If you want to read, I might suggest a good book,
                            perhaps Hemingway or Melville.
                            <br /> <br />
                            That’s why they call it, the dummy copy. This, of
                            course, is not the real copy for this entry. Rest
                            assured, the words will expand the concept. With
                            clarity. Conviction. And a little wit. In today’s
                            competitive market environment, the body copy of
                            your entry must lead the reader through a series of
                            disarmingly simple thoughts.
                          </Typography>
                          <Link
                            to={"/contact/1"}
                            style={{ textDecoration: "none" }}
                          >
                            <Button variant="contained" color="primary">
                              Contact
                            </Button>
                          </Link>
                        </Grid>
                      </Grid>
                    </Grid>
                  </Grid>
                </Paper>
              </Grid>
            </Grid>
          </Box>
        </Container>
      </div>
    </div>
  );
}
