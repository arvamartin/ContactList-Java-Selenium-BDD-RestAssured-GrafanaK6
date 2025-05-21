import { login, getContacts } from './Common/API.js';
import { sleep } from 'k6';

export let options = {
    stages: [
        {duration: '10s', target: 2},
        {duration: '20s', target: 5},
        {duration: '10s', target: 0},
    ],
};

export default function () {
    const token = login(__ENV.EMAIL || 'test@freemail.hu', __ENV.PASSWORD || 'tesztelek');
    getContacts(token);
    sleep(1);
}
