import Button from "@material-ui/core/Button";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import { makeStyles } from "@material-ui/core/styles";
import Typography from "@material-ui/core/Typography";
import Box from "@mui/material/Box";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import axios from "axios";
import React from "react";
import { Link, useParams } from "react-router-dom";
import Author from "../blogs/Author";
import Header from "../pages/header";

const useStyle = makeStyles((theme) => ({
  root: {
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
  paper: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary,
  },
  context: {
    maxWidth: "auto",
    maxheight: "auto",
  },
  media: {
    height: 400,
  },
}));

export default function Detail() {
  const [post, setPost] = React.useState(null);
  const [isLoaded, setIsLoaded] = React.useState(null);
  const params = useParams();

  const convertNumberToDate = (value) => {
    console.log(value);
    var date = new Date(value);
    console.log(date);

    return date.toDateString();
  };

  React.useState(() => {
    async function getPosts() {
      console.log(params.id);
      try {
        const respone = await axios.get(
          `http://localhost:8080/miniblogs/backend/v1/blogs/${params.id}`
        );
        console.log(respone.data);
        setPost(respone.data);
        setIsLoaded(true);
      } catch (error) {
        console.log(error);
      }
    }
    getPosts();
  }, []);

  const classes = useStyle();
  return (
    <div>
      <Header />
      {isLoaded && (
        <div className={classes.root}>
          <Container fixed>
            <Box sx={{ flexGrow: 1 }} marginTop="100">
              <Grid container spacing={2}>
                <Grid item xs={4}>
                  <Author />
                </Grid>
                <Grid item xs={8}>
                  <Card className={classes.context}>
                    <CardActionArea>
                      <CardMedia
                        className={classes.media}
                        image={post.blogPicture}
                        title="Contemplative Reptile"
                      />
                      <CardContent>
                        <Typography gutterBottom variant="h5" component="h2">
                          {post.blogName}
                        </Typography>
                        <Typography
                          variant="body2"
                          color="textSecondary"
                          component="p"
                        >
                          <p>
                            {convertNumberToDate(post.blogDate)} |{" "}
                            {post.blogType}
                          </p>
                        </Typography>

                        <Typography variant="body1" gutterBottom>
                          {post.blogContent}
                        </Typography>
                        <Link to={"/"} style={{ textDecoration: "none" }}>
                          <Button variant="contained" color="primary">
                            All Post
                          </Button>
                        </Link>
                      </CardContent>
                    </CardActionArea>
                  </Card>
                </Grid>
              </Grid>
            </Box>
          </Container>
        </div>
      )}
    </div>
  );
}
