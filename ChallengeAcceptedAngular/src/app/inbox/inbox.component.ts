import { Message } from './../models/message';
import { Router, ActivatedRoute } from '@angular/router';
import { InboxService } from './../inbox.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit {

  allMessages: Message[] = [];
  threadMessages: Message[] = [];
  reply = new Message();
  freshThread = new Message();
  receiver = new User();
  errorMessage = false;

  getAllMessageHeadsOfUser() {
    this.inboxService.allMessageHeads(this.route.snapshot.paramMap.get('id')).subscribe(
      data => {
        console.log(data);
        this.allMessages = data;
      },
      error => {
        console.log(error);
      }
    );

  }

  getThreadMessages(id) {
    this.inboxService.threadMessages(id).subscribe(
      data => {
        this.threadMessages = data;
        this.reply.threadId = data[0].threadId;
        console.log(this.threadMessages);
      },
      error => {
        console.log(error);
      }
    );
  }

  sendReply() {
    // for (let index = 0; index < this.threadMessages.length; index++) {
      if (this.threadMessages[0].sender.username !== 'AlexTheDestroyer') { // Get the 1 value from logged in user
        this.reply.receiver = new User();
        this.reply.receiver.username = this.threadMessages[0].sender.username;
      } else {
        this.reply.receiver = new User();
        this.reply.receiver.username = this.threadMessages[0].receiver.username;
      }
    // }
    this.reply.sender = new User();
    this.reply.sender.username = 'AlexTheDestroyer'; // Get this from logged in user
    this.inboxService.submitReply(this.reply).subscribe(
      data => {
        this.getThreadMessages(this.reply.threadId);
        this.reply = new Message();
      },
      error => {
        console.log(error);
      }
    );
  }

  sendMessage() {
    this.freshThread.receiver = this.receiver;
    const sender = new User();
    sender.username = 'AlexTheDestroyer'; // change to logged in user's name
    this.freshThread.sender = sender;
    console.log(this.freshThread);
    this.inboxService.submitReply(this.freshThread).subscribe(
      data => {
        this.errorMessage = false;
        this.freshThread = new Message();
        this.receiver = new User();
        this.getAllMessageHeadsOfUser();
      },
      error => {
        console.log(error);
        this.errorMessage = true;
      }
    );
  }

  deleteMessage(id) {
    this.inboxService.deleteMessage(id).subscribe(
      data => {
        this.threadMessages = [];
        this.getAllMessageHeadsOfUser();
      },
      error => {
        console.log(error);
      }
    );
  }

  constructor(private inboxService: InboxService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.getAllMessageHeadsOfUser();
    this.reply = new Message();
    this.errorMessage = false;

  }

}
