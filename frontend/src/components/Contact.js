import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import Box from "@mui/material/Box";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import Typography from "@mui/material/Typography";
import axios from "axios";
import React, { useRef } from "react";
import { useParams } from "react-router-dom";
import Author from "../blogs/Author";
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
  email: {
    "& > *": {
      width: "80ch",
      display: "grid",
    },
  },
}));

export default function Contact(props) {
  const name = useRef("");
  const emailFrom = useRef("");
  const message = useRef("");
  const params = useParams();

  const sendValue = () => {
    console.log(params);

    console.log(
      name.current.value + emailFrom.current.value + message.current.value
    );
    axios
      .post("http://localhost:8080/miniblogs/backend/v1/contacts/", {
        authorId: params.id,
        contactEmailFrom: emailFrom.current.value,
        contactName: name.current.value,
        contactMessage: message.current.value,
      })
      .then((response) => {
        console.log(response);
        alert("Successful");
      });
  };

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
                            Get in touch
                          </Typography>
                          <Typography variant="body2" gutterBottom>
                            This is some dummy copy. You’re not really supposed
                            to read this dummy copy, it is just a place holder
                            for people who need some type to visualize what the
                            actual copy might look like if it were real content.
                            <br /> <br />
                            If you want to read, I might suggest a good book,
                            perhaps Hemingway or Melville. That’s why they call
                            it, the dummy copy. This, of course, is not the real
                            copy for this entry. Rest assured, the words will
                            expand the concept. With clarity. Conviction. And a
                            little wit.
                          </Typography>
                          <form
                            className={classes.email}
                            noValidate
                            autoComplete="off"
                          >
                            <Typography
                              gutterBottom
                              variant="h9"
                              component="div"
                            >
                              Name
                            </Typography>
                            <TextField
                              id="outlined-basic"
                              size="small"
                              variant="outlined"
                              inputRef={name}
                            />
                            <Typography
                              gutterBottom
                              variant="h9"
                              component="div"
                            >
                              Email Address
                            </Typography>
                            <TextField
                              id="outlined-basic"
                              size="small"
                              variant="outlined"
                              inputRef={emailFrom}
                            />
                            <Typography
                              gutterBottom
                              variant="h9"
                              component="div"
                            >
                              Message
                            </Typography>
                            <TextField
                              id="outlined-basic"
                              variant="outlined"
                              multiline
                              rows={9}
                              inputRef={message}
                              className={classes.message}
                            />
                            <Button
                              variant="contained"
                              color="primary"
                              style={{ width: "50px" }}
                              onClick={sendValue}
                            >
                              Send
                            </Button>
                          </form>
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
