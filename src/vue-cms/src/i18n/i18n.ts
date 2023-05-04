import {createI18n} from 'vue-i18n'
import ko from './locales/ko.json'
import en from './locales/en.json'

type MessageSchema = typeof ko;
type MessageSchemaEn = typeof en;

export const i18n = createI18n<[MessageSchema | MessageSchemaEn], 'ko' | 'en'>({
    legacy: false,
    locale: 'ko',
    fallbackLocale: 'ko',
    messages: { en, ko }
})